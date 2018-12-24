'use strict'

angular.module('app.services', []).factory('InventoryItemService',
		[ "$http", function($http) {
			var service = {};
			service.getInventoryItemById = function(inventoryItemId) {
				var url = "/inventory/" + inventoryItemId;
				return $http.get(url);
			}
			service.getAllInventoryItems = function() {
				return $http.get("/inventory");
			}
			service.saveInventoryItem = function(inventoryItemDto) {
				return $http.post("/inventory", inventoryItemDto);
			}
			service.deleteInventoryItem = function(inventoryItemId) {
				return $http.delete("/inventory/" + inventoryItemId);
			}
			service.updateInventoryItem = function(inventoryItemDto) {
				return $http.put("/inventory/"+inventoryItemDto.inventoryItemId, inventoryItemDto);
			}
			return service;
		} ]);