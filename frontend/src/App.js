import './App.css';
import React from 'react';
import {ListCourses} from "./course/ListCourses";
import {ListStudent} from "./student/ListStudent";
import {StudentsInCourse} from "./student/StudentsInCourse";
import {AddStudent} from "./student/AddStudent";
import Header from "./components/Header";
import {Router} from "@reach/router";
import AddTeacher from "./teacher/AddTeacher";
import {AddCourse} from "./course/AddCourse";
import HomePage from "./components/HomePage";
import ListTeachers from "./teacher/ListTeachers";
import CourseDetail from "./course/CourseDetails";
import StudentDetails from "./student/StudentDetails";
import TeacherDetails from "./teacher/TeacherDetails";

function App() {
    return (
        <>
            <Header/>
            <div className="App container">
                <Router>
                    <HomePage path={"/"}/>
                    <ListCourses path={"/courses"}/>
                    <ListStudent path={"/students"}/>
                    <StudentDetails path={"/students/:studentUsername"}/>
                    <AddStudent path={"/students/add"}/>
                    <TeacherDetails path={"/teachers/:teacherId"}/>
                    <AddTeacher path={"/teachers/add"}/>
                    <CourseDetail path={"/courses/:courseId"}/>
                    <AddCourse exact path={"/courses/add"}/>
                    <StudentsInCourse path={"/courses/:courseId/students"}/>
                    <ListTeachers path={"/teachers"}/>
                </Router>
            </div>
        </>
    );
}

export default App;
