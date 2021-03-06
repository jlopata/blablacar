
var app = angular.module('app', ['ngRoute', 'ngCookies']);


    app.config(function($routeProvider) {
        $routeProvider
            .when('/home', {
                templateUrl : 'templates/home.html',
                controller  : 'mainController'
            })
            .when('/login', {
                templateUrl : 'templates/login.html',
                controller  : 'mainController'
            })
            .when('/register', {
                templateUrl : 'templates/register.html',
                controller  : 'mainController'
            })
            .when('/trips', {
                templateUrl : 'templates/trips.html',
                controller  : 'mainController'
            })
            .when('/trip/detail', {
                templateUrl : 'templates/tripDetail.html',
                controller  : 'mainController'
            })
            .when('/add', {
                templateUrl : 'templates/addTrip.html',
                controller  : 'mainController'
            });
    });

    app.controller('mainController', ["$scope", "$http", "$cookies", function($scope, $http, $cookies) {

        $scope.getAllTrips = function () {
             $http({
                 method: 'GET',
                 url: "/trip"
             }).then(function successCallback(response) {
                $scope.trips = response.data;
             }, function errorCallback(response){
             });
         };

        $scope.loginUser = function () {
            $http({
                method: 'POST',
                url: "/login" ,
                headers : {
                    email : $scope.login,
                    password : $scope.password
                }
            }).then(function successCallback(response) {
            }, function errorCallback(response) {
            })
        };

        $scope.logoutUser = function () {
            $http({
                method: 'POST',
                url: "/logout" ,
            }).then(function successCallback(response) {
            }, function errorCallback(response) {
            })
        };

        $scope.registerUser = function () {
            $http({
                method: 'POST',
                url: "/register" ,
                params : {
                    "email" : $scope.user.email,
                    "password" : $scope.user.password,
                    "name" : $scope.user.name
                },
            }).then(function successCallback(response) {
            }, function errorCallback(response) {
            })
        };

        $scope.addTrip = function () {
            $http({
                method: 'POST',
                url: "/addTrip" ,
                params : {
                    "from" : $scope.trip.from,
                    "to" : $scope.trip.to,
                    "price" : $scope.trip.price,
                    "seats" : $scope.trip.seats,
                    "date" : $scope.trip.date,
                    "owner" : $cookies.name
                },
            }).then(function successCallback(response) {
            }, function errorCallback(response) {
            })
        };

        $scope.setFolder = function (folder) {
            $scope.selected = folder;
            console.log($scope.selected);
        };

        $scope.selected = null;
        $scope.trips = [];
        $scope.login = null;
        $scope.password = null;
        $scope.user = {
            email : null,
            password : null,
            name : null,
        };
        $scope.trip = {
            from : null,
            to : null,
            price : null,
            seats : null,
            date : null
        };

        $scope.init = function() {
            $scope.getAllTrips();

        };

        $scope.init();
    }]);

