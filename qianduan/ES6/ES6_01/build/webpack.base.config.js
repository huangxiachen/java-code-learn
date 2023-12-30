const HtmlWebpackPlugin = require('html-webpack-plugin')
const CopyWebpackPlugin = require('copy-webpack-plugin');

module.exports = {
    entry: './src/index.js',
    output: {
        filename: 'index.js'
    },
    module: {
        rules: [{
            test: /\.js$/,
            exclude: /node_modules/,
            use: {
                loader: 'babel-loader',
                options: {
                    presets: [
                        ['@babel/preset-env', {
                            'useBuiltIns': 'entry'
                        }]
                    ],
                    plugins: ['@babel/plugin-transform-runtime']
                }
            }
        }]
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: './src/index.html',
            filename:'index.html'
        }),
        new HtmlWebpackPlugin({
            template: './src/case02变量的解构赋值.html',
            filename:'case02变量的解构赋值.html'
        }),
        // new HtmlWebpackPlugin({
        //     template: './src/case03模板字符串.html'
        // }),
        new HtmlWebpackPlugin({
            template: './src/case04对象的简化写法.html',
            filename:'case04对象的简化写法.html'
        }),
        new HtmlWebpackPlugin({
            template: './src/case05箭头函数.html',
            filename:'case05箭头函数.html'
        }),
        new HtmlWebpackPlugin({
            template: './src/case06箭头函数实例.html',
            filename:'case06箭头函数实例.html'
        }),
        new HtmlWebpackPlugin({
            template: './src/case07test参数.html',
            filename:'case07test参数.html'
        }),
        new HtmlWebpackPlugin({
            template: './src/case08拓展运算符.html',
            filename:'case08拓展运算符.html'
        }),
        new CopyWebpackPlugin([{
            from: 'static',
            to: 'static'
        }, ])
    ],
    stats: {
        children: false
    }
}
