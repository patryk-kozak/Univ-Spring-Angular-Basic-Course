angular.module('clinicApp')
    .factory('errorService', ['$rootScope',
        function ($rootScope) {
            
            service.logError = function (error)
            {
                console.log(error);
            }
            
            return service;          
        }]);