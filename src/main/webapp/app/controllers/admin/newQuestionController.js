happySurvey.controller('newQuestionController', ['$scope', '$http' , function($scope, $http) {

	'use strict';
	
	$scope.componentHandler = function() {
		
	}
	
	$scope.createQuestionClicked = function() {
		
		//TODO implement
		console.log("create question clicked");
	}
	$scope.options = ["Auswahl 1", "Auswahl 2"];
	
	$scope.addOptionClicked = function() {
		
		$scope.options.push("Auswahl " + ($scope.options.length +1));
		 
	}
	
	$scope.removeOptionClicked = function(item) {

		  var index = $scope.options.indexOf(item);
		   $scope.options.splice(index, 1);
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