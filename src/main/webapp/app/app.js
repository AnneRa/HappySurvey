    var happySurvey = angular.module('happySurvey', [ 'ngRoute', 'ngCookies',
                    'ngAnimate', 'ngSanitize', 'ngMaterial', 'crumble' ]);
    happySurvey.config(config);
    happySurvey.run(run);
    
    config.$inject = [ '$routeProvider', '$locationProvider' ];
    function config($routeProvider, $locationProvider) {
            $routeProvider
           .when('/home', {
                   // Später gegen die richtige Home Seite für Teilnehmer ersetzen 
                   templateUrl : 'views/admin/login.html',
                   controller : 'loginController',
                   label : 'Login'
           })
           
           .when('/admin/home', {
                   templateUrl : 'views/admin/overviewAdmin.html',
                   controller : 'overviewAdminController',
                   label : 'Übersicht'
           })
           
           .when('/newSurvey', {
                   templateUrl : 'views/admin/newSurvey.html',
                   controller : 'newSurveyController',
                   label: 'Neue Umfrage'
           })
           
           .when('/editSurvey', {
                   templateUrl: 'views/admin/editSurvey.html',
                   controller: 'newSurveyController'
           })
           .when('/overviewQuestions', {
		templateUrl: 'views/admin/overviewQuestions.html'
	})
           
           .when('/newQuestion', {
                   templateUrl : 'views/admin/newQuestion.html',
                   controller : 'newQuestionController',
                   label : 'Neue Frage'
           })
           .when('/', {
                   redirectTo : '/home',
                   label : '/'
           })
   
           .when('/admin', {
                   redirectTo : '/admin/home',
                   label : 'Übersicht'
           })
           .when('/getSurvey/:link', {
        	  templateUrl : 'views/participant/survey_conduct_greeting.html',
		controller: 'surveyConductController'
	})
           
           .otherwise({
                   redirectTo : '/home'
           });
   }
   
   // Sehr wichtig! Nicht löschen!
   run.$inject = [ '$rootScope', '$location', '$cookies', '$http' ];
   function run($rootScope, $location, $cookies, $http) {
   
           $rootScope.$on('$locationChangeStart', function(event, next, current) {
                   // redirect to login page if not logged in and trying to access a restricted page
                   var restrictedPage = $location.path().search(/admin/i) != -1;
                   var loggedIn = $cookies.get('currentUser');
                   if (restrictedPage && !loggedIn) {
                           $location.path('/admin/login');
                   }
           });
   }

	/*
	
<<<<<<< HEAD
=======
	.when('/newSurvey', {
		templateUrl : 'views/admin/newSurvey.html',
		controller : 'newSurveyController',
		label: 'Neue Umfrage'
	})
	
	.when('/editSurvey', {
		templateUrl: 'views/admin/editSurvey.html',
		controller: 'newSurveyController'
	})
	
	.when('/overviewQuestions', {
		templateUrl: 'views/admin/overviewQuestions.html'
	})
	
	.when('/newQuestion', {
		templateUrl : 'views/admin/newQuestion.html',
		controller : 'newQuestionController',
		label : 'Neue Frage'
	})
	
	.when('/', {
		redirectTo : '/home',
		label : '/'
	})

	.when('/admin', {
		redirectTo : '/admin/home',
		label : 'Übersicht'
	})
	
	.otherwise({
		redirectTo : '/home'
	});
}

// Sehr wichtig! Nicht löschen!
run.$inject = [ '$rootScope', '$location', '$cookies', '$http' ];
function run($rootScope, $location, $cookies, $http) {

	$rootScope.$on('$locationChangeStart', function(event, next, current) {
		// redirect to login page if not logged in and trying to access a restricted page
		var restrictedPage = $location.path().search(/admin/i) != -1;
		var loggedIn = $cookies.get('currentUser');
		if (restrictedPage && !loggedIn) {
			$location.path('/admin/login');
		}
	});
}
>>>>>>> refs/remotes/origin/devNeu
*/