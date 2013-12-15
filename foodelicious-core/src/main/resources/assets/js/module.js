var recipeModule = angular.module('recipeApp', ['ngRoute']);

recipeModule.config(function($locationProvider,$routeProvider){
  $routeProvider
    .when("/index.html", {templateUrl: "/views/partials/recipe_overview.html"}
    .when("/new", {templateUrl: "/views/partials/recipe_detail.html"})
  );
});
