var happySurvey = angular.module('happySurvey',['ngRoute', 'ngCookies', 'ngAnimate', 'ngSanitize', 'ngMaterial']);
happySurvey.config(config);
happySurvey.run(run);

config.$inject = ['$routeProvider', '$locationProvider'];
function config($routeProvider, $locationProvider) {
    $routeProvider
	.when('/home', {
		// Später gegen die richtige Home Seite für Teilnehmer ersetzen 
		templateUrl: 'views/admin/login.html',
		controller: 'loginController'
	})
    .when('/admin/home', {
		templateUrl: 'views/admin/overviewAdmin.html',
		controller: 'overviewAdminController'
	}) 
	
	.when('/newSurvey', {
		templateUrl: 'views/admin/newSurvey.html',
		controller: 'newSurveyController'
	})
	.otherwise({ redirectTo: '/home' });
}

// Sehr wichtig! Nicht löschen!
run.$inject = ['$rootScope', '$location', '$cookies', '$http'];
function run($rootScope, $location, $cookies, $http) {

    $rootScope.$on('$locationChangeStart', function (event, next, current) {
        // redirect to login page if not logged in and trying to access a restricted page
    	var restrictedPage = $location.path().search(/admin/i) != -1;
        var loggedIn = $cookies.get('currentUser');
        if (restrictedPage && !loggedIn) {
            $location.path('/admin/login');
        }
    });
}

