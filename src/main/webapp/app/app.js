    var happySurvey = angular.module('happySurvey', [ 'ngRoute', 'ngCookies',
                    'ngAnimate', 'ngSanitize', 'ngMaterial', 'ngMessages', 'ng-breadcrumbs', 'nvd3']);

    happySurvey.config(config);
    happySurvey.run(run);
    
    config.$inject = [ '$routeProvider', '$locationProvider' ];
    function config($routeProvider, $locationProvider) {
            $routeProvider
           .when('/login', {
                   // Später gegen die richtige Home Seite für Teilnehmer ersetzen 
                   templateUrl : 'views/admin/login.html',
                   controller : 'loginController',
           })
           
           .when('/admin/home', {
                   templateUrl : 'views/admin/overviewAdmin.html',
                   controller : 'overviewAdminController',
                   label : 'Home'
           })
           
           .when('/admin/newSurvey', {
                   templateUrl : 'views/admin/surveyAdministration.html',
                   controller : 'surveyController',
                   label: 'Umfrage anlegen'
           })
           
           .when('/admin/editSurvey/:id', {
                   templateUrl: 'views/admin/surveyAdministration.html',
                   controller: 'surveyController',
                   label: 'Umfrage ändern'
           })
           
           .when('/admin/:id/questions', {
        	   		templateUrl: 'views/admin/overviewQuestions.html',
        	   		controller: 'overviewQuestionsController',
        	   		label:'Alle Fragen'
           })
           
           .when('/admin/:id/groups', {
        	   		templateUrl: 'views/admin/overviewGroups.html',
        	   		controller: 'overviewGroupsController',
        	   		label:'Alle Gruppen'
           })
           
           .when('/admin/:id/newQuestion', {
                   templateUrl : 'views/admin/newQuestion.html',
                   controller : 'newQuestionController',
                   label:'Neue Frage'
           })
           
           .when('/admin/:id/editQuestion/:questionId', {
                   templateUrl : 'views/admin/newQuestion.html',
                   controller : 'newQuestionController'
           })
           
           .when('/admin/charts', {
                   templateUrl : 'views/admin/charts.html',
                   controller : 'ChartCtrl'
           })
           
           .when('/', {
                   redirectTo : '/login',
           })
   
           .when('/admin', {
                   redirectTo : '/admin/home',
                   label : 'Home'
           })
           
           .when('/getSurvey/:link', {
        	   		templateUrl: 'views/participant/survey_intro.html',
        	   		controller: 'surveyIntroController'
           })
           
           .when('/conductSurvey/:link', {
        	   	templateUrl: 'views/participant/survey_conduct.html',
        	   	controller: 'surveyConductController'  
           })
           
           .when('/end/:link', {
        	   	templateUrl: 'views/participant/finishSurvey.html'  
           })
           
           .when('/chart/:link', {
        	   	templateUrl: 'views/participant/chartSurvey.html',
        	   	controller: 'chartSurveyCtrl'
           })
           
           .otherwise({
                   redirectTo : '/admin/home'
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