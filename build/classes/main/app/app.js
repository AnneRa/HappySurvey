var happySurvey = angular.module('happySurvey',['ngRoute', 'ngAnimate', 'ngSanitize', 'ngMaterial']);

happySurvey.config(['$routeProvider', function($routeProvider){
	
	$routeProvider
		.otherwise('/home')
		.when('/home', {
			templateUrl: 'views/overviewAdmin.html',
			controller: 'overviewAdminController'
		}) 
		.when('/login', {
			templateUrl: 'views/login.html',
			controller: 'loginController'
		})
		.when('/newSurvey', {
			templateUrl: 'views/newSurvey.html',
			controller: 'newSurveyController'
		});
		
		
}]);



