angular.module('clinicApp')
    .factory('authInterceptor', ['$rootScope', '$q', 'session', 'AUTH_STATUS',
        function ($rootScope, $q, session, AUTH_STATUS) {
            return {
                responseError: function (response) {
                    $rootScope.$broadcast({
                        401: AUTH_STATUS.notAuthenticated,
                        403: AUTH_STATUS.notAuthorized,
                        419: AUTH_STATUS.sessionTimeout,
                        440: AUTH_STATUS.sessionTimeout
                    }[response.status], response);
                    return $q.reject(response);
                }
            };
        }]);