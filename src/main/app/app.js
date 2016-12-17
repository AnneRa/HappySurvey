var happySurvey = angular.module('happySurvey',['ui.router', 'ngAnimate', 'ngSanitize', 'ngMaterial']);

happySurvey.config(['$urlRouterProvider', '$stateProvider', function($urlRouterProvider, $stateProvider ){
	$urlRouterProvider.otherwise('/');


	//happySurvey.config(RoutesManager);

//RoutesManager.$inject = ['$stateProvider', '$urlRouterProvider'];
//function RoutesManager($stateProvider, $urlRouterProvider) {
//	var signinState = {
//			name: 'signin',
//			url: '/signin',
//			templateUrl: '../views/partial-signin.html'
//	}
	
	
	
//	$stateProvider.state(signinState);
	
//	$urlRouterProvider.otherwise('/');
	
//}
	$stateProvider
		.state('private', {
			url:'/',
			templateUrl:'index.html',
			template:'<ui-view></ui-view>'
		})
		.state('private.overviewAdmin', {
			url:'/overviewAdmin',
			templateUrl:'views/overviewAdmin.html'
		});
}]);

