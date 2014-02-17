/*jshint node:true*/
'use strict';

module.exports = function(grunt) {
	// load all grunt tasks
	require('matchdep').filterDev('grunt-*').forEach(grunt.loadNpmTasks);


	// configurable paths
	var appPaths = {
		app: '.',
	};

	grunt.initConfig({
		appConfig: appPaths,

		pkg: grunt.file.readJSON('package.json'),

		connect: {
			server: {
				options: {
					port: 8081,
					base: '.',
					keepalive: true
				},
				proxies: [
					{
						context: '/foodelicious',
						host: 'localhost',
						port: 8080,
						changeOrigin: false,
						https: false,
						keepalive: true,
					}
				]
			}
		},
		open: {
			server: {
				path: 'http://localhost:<%= connect.options.port %>'
			}
		},
		watch: {
			options: {
				livereload: true,
			},
			jshint: {
				files: '<%= jshint.all %>',
				tasks: ['jshint']
			},
			livereload: {
				options: {
					livereload: true
				},
				files: [
					'<%= appConfig.app %>/*.html',
					'{.tmp,<%= appConfig.app %>}/styles/{,*/}*.css',
					'{.tmp,<%= appConfig.app %>}/scripts/{,*/}*.js',
					'<%= appConfig.app %>/images/{,*/}*.{png,jpg,jpeg,gif,webp}'
				]
			}
		},
		jshint: {
			options: {
				jshintrc: '.jshintrc',
				force: true
			},
			all: [
				'Gruntfile.js',
				'<%= appConfig.app %>/js/controllers.js',
				'<%= appConfig.app %>/js/module.js',
			]
		},
	});

	grunt.registerTask('server', function (target) {
		grunt.task.run([
			'connect:server',
			'configureProxies:server',
			'watch'
		]);
	});
};
