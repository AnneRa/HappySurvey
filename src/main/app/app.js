var happySurvey = angular.module('happySurvey',['ui.router', 'ngAnimate', 'ngSanitize', 'ngMaterial']);

happySurvey.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/home');
	
	$stateProvider
	.state('public', {
		abstract:true,
		templateUrl:'../src/main/index.html'
		//template:"<ui-view/>"
	})
	.state('public.site', {
		url:'/start',
		templateUrl:'../src/main/views/hellopage.html'
	});
	
	$stateProvider
	.state('private', {
		abstract:true,
		template:"<ui-view/>"
	});
	
}]);