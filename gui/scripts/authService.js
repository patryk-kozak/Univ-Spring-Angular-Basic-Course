var clinicWS = "http://localhost:8080/SSK/";

angular.module('clinicApp')
    .factory("authService", ['$http', '$rootScope', '$window', 'errorService', 'session', 'AUTH_STATUS',
        function ($http, $rootScope, $window, errorService, session, AUTH_STATUS) {

            service.login = function (code, isDoctor) {
                if (code != null) {
                    $http.get(clinicWS + "/auth/" + code +  "/" + isDoctor)
                        .then(onLogin, onLoginError);
                }
                else {
                    errorService.logError("authService -> login(): parameters are empty");
                }
            }

            var onLogin = function (response) {
                var user = response.data[0];
                session.create(user);
            }

            var onLoginError = function () {
                errorService.logError("authService -> login() error, authentication failed when connecting to WS");
            }

            service.logout = function () {
                session.destroy()
            }

            service.isAuthorized = function (roles) {
                var result = false;
                angular.forEach(roles, function (value, key) {
                    if (value == session.userRole) {
                        result = true;
                    }
                })
                return result;
            }

            service.isAuthenticated = function () {
                return session.userRole != null && session.user != null;
            }

            return service;
        }
    ]);
