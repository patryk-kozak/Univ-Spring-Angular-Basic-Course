var app = angular.module('clinicApp', ["ui.router"]);

// ***
// Constants
// ***
app
    .constant('USER_ROLES',
        {
            all: '*',
            admin: 'admin',
            doctor: 'doctor',
            patient: 'patient'
        }
        )
    .constant('AUTH_STATUS',
        {
            loginSuccess: 'login_success',
            loginFailed: 'login_failed',
            logoutSuccess: 'logout_success',
            sessionTimeout: 'session_timeout',
            notAuthenticated: 'not_authenticated',
            notAuthorized: 'not_authorized'
        }
        )
// ***
// Routing
// ***
app
    .config(function ($stateProvider, $urlRouterProvider, USER_ROLES) {

        $urlRouterProvider.otherwise("/login");

        $stateProvider
            .state('404',
                {
                    url: "/404",
                    templateUrl: "templates/404.html",
                    data:
                    {
                        authorizedRoles: [USER_ROLES.all]
                    }
                })
            .state('login',
                {
                    url: "/login",
                    templateUrl: "templates/login.html",
                    data:
                    {
                        authorizedRoles: [USER_ROLES.all]
                    }
                })
            .state('logout',
                {
                    url: "/logout",
                    templateUrl: "templates/logout.html",
                    data:
                    {
                        authorizedRoles: [USER_ROLES.admin, USER_ROLES.doctor, USER_ROLES.patient]
                    }
                })
            .state('dashboard',
                {
                    url: "/dashboard",
                    templateUrl: "templates/dashboard.html",
                    data:
                    {
                        authorizedRoles: [USER_ROLES.admin, USER_ROLES.doctor, USER_ROLES.patient]
                    }
                })
            .state('doctors',
                {
                    url: "/doctors",
                    templateUrl: "templates/doctors.html",
                    data:
                    {
                        authorizedRoles: [USER_ROLES.admin]
                    }
                })
            .state('patients',
                {
                    url: "/patients",
                    templateUrl: "templates/patients.html",
                    data:
                    {
                        authorizedRoles: [USER_ROLES.admin, USER_ROLES.doctor]
                    }
                })
            .state('visits',
                {
                    url: "/visits",
                    templateUrl: "templates/visits.html",
                    data:
                    {
                        authorizedRoles: [USER_ROLES.doctor, USER_ROLES.patient]
                    }
                }
                )
    });
    
// ***
// $rootScope
// ***

$rootScope.$on('$stateChangeStart', function (event, next) {
    var authorizedRoles = next.data.authorizedRoles;
    if (!authService.isAuthorized(authorizedRoles)) {
        event.preventDefault();
        if (Auth.isAuthenticated()) {
            $rootScope.$broadcast(AUTH_STATUS.notAuthorized);
        } else {
            $rootScope.$broadcast(AUTH_STATUS.notAuthenticated);
        }
    }
})
