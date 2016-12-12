var happySurvey = angular.module('happySurvey',['ui.router', 'ngAnimate', 'ngSanitize', 'ngMaterial']);

happySurvey.config(RoutesManager);

RoutesManager.$inject = ['$stateProvider', '$urlRouterProvider'];
function RoutesManager($stateProvider, $urlRouterProvider) {
	
	var signinState = {
			name: 'signin',
			url: '/signin',
			templateUrl: '../views/partial-signin.html'
	}
	
	
	
	$stateProvider.state(signinState);
	
	$urlRouterProvider.otherwise('/');
	
}
