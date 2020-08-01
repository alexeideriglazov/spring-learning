var app = angular.module("springLearning", []);

app.controller("AppCtrl", function($scope, $http){
    $scope.websites=[{
        iconImageUrl: '',
        id: 'stackoverflow',
        website: 'stackoverflow.com',
        title: 'StackOverFlowWebsite',
        description: 'Description'
    }];

    $http({
        method: 'get',
        url: 'http://localhost:8080/api/stackoverflow'
    }).then(function (response) {
        console.log(response, 'res');
        $scope.websites = response.data;
    },function (error){
        console.log(error, 'can not get data.');
    });
});