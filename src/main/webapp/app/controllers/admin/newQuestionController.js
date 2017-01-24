happySurvey.controller('newQuestionController', ['$scope', '$http' , function($scope, $http) {

	'use strict';
	
	$scope.componentHandler = function() {
		
	}
	
	$scope.createQuestionClicked = function() {
		
		//TODO implement
		console.log("create question clicked");
	}
	
	$scope.numberOfOptions = 2;
	$scope.addOptionClicked = function() {
		
		$scope.numberOfOptions++;
		
		var htmlElementId = "mca_option_container" + $scope.numberOfOptions;
		
		 var optionNew = '<div id="' + htmlElementId + '" class="mdl-textfield" id="optionNumber">' +
					'<input class="mdl-textfield__input" type="text" placeholder="Auswahl ' + $scope.numberOfOptions + '" id="mca_option' + $scope.numberOfOptions + '">' +
					'<button class="mdl-button mdl-js-button mdl-button--icon right-floating" ng-click="removeOptionClicked(' + htmlElementId + ')">' + 
					  '<i class="material-icons">delete</i>' +
					'</button>' +
					'</div>';
		 var dropDownAttributesElementsContainer = document.getElementById('choiceAttributesElementsContainer');
		 dropDownAttributesElementsContainer.innerHTML += optionNew;
		 
		 var elementNew = document.getElementById(htmlElementId);
		 var body = angular.element(document.querySelector('body'));
		 var $injector = body.injector();
		 var $compile = $injector.get('$compile');
		 $compile(elementNew)($scope);
		 $scope.$apply();
		 
	}
	
	$scope.removeOptionClicked = function(optionId) {
		
		var parent = document.getElementById("choiceAttributesElementsContainer");
		var child = document.getElementById(optionId);
		parent.removeChild(child);
	}
	
	$scope.onQuestionTypeChanged = function() {
		
		var typeSpecificAttributesContainer = document.getElementById('typeSpecificAttributes');
		var linearScaleSpecificAttributesContainer = document.getElementById('linearScaleSpecificAttributesContainer');
		var choiceAttributesContainer = document.getElementById('choiceAttributesContainer');
		var textFieldAttributesContainer = document.getElementById('textFieldAttributesContainer');
		
		typeSpecificAttributesContainer.style.display = 'none';
		linearScaleSpecificAttributesContainer.style.display = 'none';
		choiceAttributesContainer.style.display = 'none';
		textFieldAttributesContainer.style.display = 'none';
		
		var list = document.getElementById('questionType');
		var selectedType = list[list.selectedIndex].value;
		
		switch(selectedType){
		
		case "linearScale": 
			linearScaleSpecificAttributesContainer.style.display = 'block';
			typeSpecificAttributesContainer.style.display = 'block';
			break;
		
		case "multipleChoice":
		case "dropDown":
			choiceAttributesContainer.style.display = 'block';
			typeSpecificAttributesContainer.style.display = 'block';
			break;
			
		case "textField":
			textFieldAttributesContainer.style.display = 'block';
			break;
		
		default:
			break;
		}
	
	}
}]);