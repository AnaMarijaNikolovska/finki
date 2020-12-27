import React, {useEffect, useState} from 'react';
import axios from '../components/AxiosConfig'
import {Link} from "@reach/router";

export function ListCourses() {
    const [courses, setCourses] = useState(null);
    const [checkedCourse, setCheckedCourse] = useState(null);
    useEffect(() => {
        axios.get("/courses")
            .then(res => {
                setCourses(res.data)
            })
    }, []);
    const selectCourse = courseId => {
        setCheckedCourse(courseId)
    }
    return (
        <div>
            <header>
                <h1>Courses List</h1>
            </header>
            <main>
                <h2>Choose course:</h2>
                <ul>
                    {courses && courses.length > 0 && courses.map(course =>
                        <li key={course.id} style={{listStyleType: "none"}}>
                            <input key={course.id} type="radio" value={course.id} name={course.id}
                                   onChange={() => selectCourse(course.id)}/>
                            <label> {course.name} </label>
                        </li>)}
                </ul>
                <br/>
                <Link to={"/students"} state={{courseId: checkedCourse}}>Submit</Link>
                <br/>
                <Link to={"/courses/add"}>Add Course</Link>
            </main>
        </div>
    )
}
