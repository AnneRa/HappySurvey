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