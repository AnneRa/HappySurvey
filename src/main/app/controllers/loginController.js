happySurvey.controller('loginController', ['$scope', function($scope) {
	
	'use strict';
	
	$scope.email = "";
    $scope.password = "";
    $scope.login = login;
    
}]);

//(function() {
//  'use strict';
//  angular.module('HSLogin',[])
//        .controller('HSLoginController', HSLoginController);
//
//        function HSLoginController($scope, $filter) {
//          $scope.email = "";
//          $scope.password = "";
//          $scope.login = login;
//        }
//
//        function login() {
//
//        }
//}());
