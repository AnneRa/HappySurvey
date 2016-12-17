var happySurvey = angular.module('happySurvey',['ngRoute', 'ngAnimate', 'ngSanitize', 'ngMaterial']);

happySurvey.config(['$routeProvider', function($routeProvider){
	
	$routeProvider
		.otherwise('/home')
		.when('/home', {
			templateUrl:'views/overviewAdmin.html'
		}) 
		.when('/login', {
			templateUrl: 'views/login.html',
			controller: 'loginController'
		})

}]);



