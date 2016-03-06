angular.module('clinicApp').service('session', function ($rootScope, USER_ROLES) {

    this.create = function (user) {
        this.user = user;
        this.userRole = user.userRole;
    };

    this.destroy = function () {
        this.user = null;
        this.userRole = null;
    };


    return this;
});