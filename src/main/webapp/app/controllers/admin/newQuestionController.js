happySurvey.controller('newQuestionController', ['$scope', '$http' , function($scope, $http) {

	'use strict';
	
	$scope.componentHandler = function() {
		
	}
	
	$scope.createQuestionClicked = function() {
		
		//TODO implement
		console.log("create question clicked");
	}
	
	$scope.onQuestionTypeChanged = function() {
		
		var typeSpecificAttributesContainer = document.getElementById('typeSpecificAttributes');
		var linearScaleSpecificAttributesContainer = document.getElementById('linearScaleSpecificAttributesContainer');
		var multipleChoiceAttributesContainer = document.getElementById('multipleChoiceAttributesContainer');
		var dropDownAttributesContainer = document.getElementById('dropDownAttributesContainer');
		var textFieldAttributesContainer = document.getElementById('textFieldAttributesContainer');
		
		typeSpecificAttributesContainer.style.display = 'none';
		linearScaleSpecificAttributesContainer.style.display = 'none';
		multipleChoiceAttributesContainer.style.display = 'none';
		dropDownAttributesContainer.style.display = 'none';
		textFieldAttributesContainer.style.display = 'none';
		
		var list = document.getElementById('questionType');
		var selectedType = list[list.selectedIndex].value;
		
		switch(selectedType){
		
		case "linearScale": 
			linearScaleSpecificAttributesContainer.style.display = 'block';
			typeSpecificAttributesContainer.style.display = 'block';
			break;
		
		case "multipleChoice":
			multipleChoiceAttributesContainer.style.display = 'block';
			typeSpecificAttributesContainer.style.display = 'block';
			break;
		
		case "dropDown": 
			dropDownAttributesContainer.style.display = 'block';
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