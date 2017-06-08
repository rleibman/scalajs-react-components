'use strict';

var webpack = require('webpack');
//var CommonsChunkPlugin = webpack.optimize.CommonsChunkPlugin;
var _ = require('lodash');

module.exports = _
		.merge(
				require('../assets/scalajs.webpack.config'),
				{
					entry : {
						index : "../bundles/index.js"
					},
					plugins : [ new webpack.NoEmitOnErrorsPlugin(),
//							new CommonsChunkPlugin({
//								name : "index"
//							}) 
					],
					module : {
						loaders : [
								{
									test : /\.css$/,
									loader : 'style-loader!css-loader'
								},
								{
									test : /\.(jpe?g|png|gif|svg)$/i,
									loaders : [
											'file?hash=sha512&digest=hex&name=[hash].[ext]',
											'image-webpack?bypassOnDebug&optimizationLevel=7&interlaced=false' ]
								} ],
						rules : [ {
							test : /\.css$/,
						// use : [ 'style-loader', 'css-loader' ]
						}, {
							test : /\.(png|jpg|gif|svg|eot|ttf|woff|woff2)$/,
							loader : 'url-loader',
							options : {
								limit : 10000
							}
						} ]
					}
				})
