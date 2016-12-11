var happySurvey = angular.module('happySurvey',['ui.router', 'ngAnimate', 'ngSanitize', 'ngMaterial']);

happySurvey.config(['$urlRouterProvider', '$stateProvider', function($urlRouterProvider, $stateProvider ){
	$urlRouterProvider.otherwise('/');
	
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