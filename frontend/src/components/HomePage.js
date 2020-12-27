import React, {useEffect, useState} from "react";
import axios from "./AxiosConfig";
import {Link} from "@reach/router";

export default function HomePage() {
    const [listcourses, setListCourses] = useState(null);
    useEffect(() => {
        axios.get("/courses")
            .then(res => {
                setListCourses(res.data)
            })
    }, []);

    const [listteachers, setListteachers]=useState(null);
    useEffect(() => {
        axios.get("/teachers")
            .then(res => {
                setListteachers(res.data)
            })
    }, []);

    const [liststudents, setListstudents]=useState(null);
    useEffect(() => {
        axios.get("/students")
            .then(res => {
                setListstudents(res.data)
            })
    }, []);

    return (
        <div>
            <header>
                <h1>Courses</h1>
            </header>
            <main>
                <ul>
                    {listcourses && listcourses.length > 0 && listcourses.map(course =>
                        <li key={course.id} style={{listStyleType: "none"}}>
                            <Link to={`courses/${course.id}/students`}> {course.name} </Link>
                        </li>)}
                </ul>
                <br/>
                <h1>Teachers</h1>
                <ul>
                    {listteachers && listteachers.length > 0 && listteachers.map(teacher =>
                        <li key={teacher.id} style={{listStyleType: "none"}}>
                            <Link to={`teachers/${teacher.id}/teachers`}> {teacher.name + " " + teacher.surname} </Link>
                        </li>)}
                </ul>
                <br/>
                <h1>Students</h1>
                <ul>
                    {liststudents && liststudents.length > 0 && liststudents.map(student =>
                        <li key={student.username} style={{listStyleType: "none"}}>
                            <Link to={`students/${student.username}/students`}> {student.name + " " + student.surname} </Link>
                        </li>)}
                </ul>
            </main>
        </div>
    )
}