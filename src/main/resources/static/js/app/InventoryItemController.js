'use strict'

var module = angular.module('app.controllers', []);
module.controller("InventoryItemController", [ "$scope", "InventoryItemService",
		function($scope,InventoryItemService) {

			$scope.inventoryItemUpdateBoolean = false;

			function resetForm(){
				$scope.inventoryItemDto = {
					inventoryItemId : null,
					inventoryItemName : null,
					inventoryItemAmount : null,
					inventoryItemCode : null
				};
			}

			InventoryItemService.getAllInventoryItems().then(function(value) {
				$scope.allInventoryItems= value.data;
			});

			$scope.saveInventoryItem = function(){
				InventoryItemService.saveInventoryItem($scope.inventoryItemDto).then(function () {
					InventoryItemService.getAllInventoryItems().then( function (value) {
						$scope.allInventoryItems = value.data;
						resetForm();
					}, function(reason) {
						console.log("something wrong");
					}, function(value) {
						console.log("no callback");
					})
				})
			}

			$scope.deleteInventoryItem = function(inventoryItemId){
				InventoryItemService.deleteInventoryItem(inventoryItemId).then(function () {
					InventoryItemService.getAllInventoryItems().then( function (value) {
						$scope.allInventoryItems = value.data;
					}, function(reason) {
						console.log("something wrong");
					}, function(value) {
						console.log("no callback");
					})
				})
			}

			$scope.enableUpdateInventoryItem = function(inventoryItem){
				$scope.inventoryItemUpdateBoolean = true;
				$scope.inventoryItemDto = {
					inventoryItemId : inventoryItem.inventoryItemId,
					inventoryItemName : inventoryItem.inventoryItemName,
					inventoryItemAmount : inventoryItem.inventoryItemAmount,
					inventoryItemCode : inventoryItem.inventoryItemCode
				};
			}

			$scope.cancelUpdateInventoryItem = function () {
				resetForm();
				$scope.inventoryItemUpdateBoolean = false;
			}

			$scope.updateInventoryItem = function(inventoryItemDto){
				InventoryItemService.updateInventoryItem(inventoryItemDto).then(function () {
					InventoryItemService.getAllInventoryItems().then( function (value) {
						$scope.allInventoryItems = value.data;
						resetForm();
						$scope.inventoryItemUpdateBoolean = false;
					}, function(reason) {
						console.log("something wrong");
					}, function(value) {
						console.log("no callback");
					})
				})
			}
		}
		]
);