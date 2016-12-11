var happySurvey = angular.module('happySurvey',['ui.router', 'ngAnimate', 'ngSanitize', 'ngMaterial']);

happySurvey.config(RoutesManager);

RoutesManager.$inject = ['$stateProvider', '$urlRouterProvider'];
function RoutesManager($stateProvider, $urlRouterProvider) {
	
	var signinState = {
			name: 'signin',
			url: '/signin',
			templateUrl: '../views/signin.template.html'
	}
	
	var homeState = {
			name: 'home',
			url: '/',
			templateUrl: '../index.html'
	}
	
	$stateProvider.state(signinState);
	$stateProvider.state(homeState);
	
	$urlRouterProvider.otherwise('/');
	
}


/*funktioniert noch nicht*/
//happySurvey.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
//	
	
//	
//	$stateProvider
//	.state('public', {
//		abstract:true,
//		templateUrl:'../src/main/index.html'
//		//template:"<ui-view/>"
//	})
//	.state('public.site', {
//		url:'/start',
//		templateUrl:'../src/main/views/hellopage.html'
//	});
//	
//	$stateProvider
//	.state('private', {
//		abstract:true,
//		template:"<ui-view/>"
//	});
	
//}]);