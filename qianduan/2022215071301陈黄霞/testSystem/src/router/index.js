// 该文件专门用于创建整个应用的路由器
import Vue from 'vue'
import VueRouter from 'vue-router'
//引入组件
import Home from '@/components/Home'
import Class from '@/components/Class'
import Student from '@/components/Student'
import Community from '@/components/Community'
import About from '@/components/About'
import Make from '@/components/test/Make'
import Maketest from '@/components/test/Maketest'
import AnswerManage from '@/components/test/AnswerManage'
import Makeclass from '@/components/class/Makeclass'
import Manage from '@/components/test/Manage'
import Makeup from '@/components/test/Makeup'
import ShowStudent from '@/components/stu/ShowStudent'
import StudentClass from '@/components/stu/StudentClass'
import Wellcome from '@/components/about/Wellcome'
import WellcomePingFen from '@/components/about/WellcomePingFen'
import MakeExecrise from '@/components/test/MakeExecrise'
import MakeQuestion from '@/components/test/MakeQuestion'
import MakeTestQuestion from '@/components/test/MakeTestQuestion'

// 调用Vue.use() 吧VueRouter安装为Vue的插件
Vue.use(VueRouter)

// 创建并暴露一个路由器
export default new VueRouter({
    routes: [
        {
            path: "/",
            redirect: '/home',

        },
        {
            path: '/about',
            component: About,
            redirect: '/wellcome',
            children: [

                {
                    path: '/wellcome',
                    component: Wellcome
                },
                {
                    path: '/wellcomePingFen',
                    component: WellcomePingFen
                }

            ]
        },
        {
            path: '/home',
            component: Home,
            redirect: '/test/manage',
            children: [
                {
                    path: '/test/manage',
                    component: Manage
                },
                {
                    path: '/test/makeup',
                    component: Makeup
                },
                {
                    path: '/test/answerManage',
                    component: AnswerManage
                },

            ]
        },
        {
            path: '/test/make',
            component: Make,
            redirect: '/test/maketest',
            children: [
                {
                    path: '/test/maketest',
                    component: Maketest

                },
                {
                    path: '/test/makeExecrise',
                    component: MakeExecrise
                },
                {
                    path: '/test/makeTestQuestion',
                    component: MakeTestQuestion
                },
                {

                    path: '/test/makequestion',
                    component: MakeQuestion

                }

            ]

        },
        {
            path: '/class',
            component: Class,
            redirect: '/class/makeclass',
            children: [
                {
                    path: '/class/makeclass',
                    component: Makeclass,

                }
            ]

        },
        {
            path: '/student',
            component: Student,
            redirect: '/stu/list',
            children: [
                {
                    path: '/stu/list',
                    component: ShowStudent
                },
                {
                    path: '/stu/clazz',
                    component: StudentClass
                }
            ]
        },
        {
            path: '/community',
            component: Community
        },

    ]
})