import React, {useEffect, useState} from 'react';
import axios from "../components/AxiosConfig";
import {Link, navigate} from "@reach/router";
import Button from "react-bootstrap/Button";

export function ListStudent({location}) {
    const [studentInCourse, setStudentInCourse] = useState({
        courseId: location?.state?.courseId ?? 0,
        studentUsername: ""
    });
    const [students, setStudents] = useState(null);
    useEffect(() => {
        axios.get("/students")
            .then(res => {
                setStudents(res.data)
            })
    }, []);
    const addStudentInCourse = () =>{
        axios.post("courses/add-student", studentInCourse)
            .then(value => navigate("/courses"))
    }
    return (
        <div>
            <header>
                <h1>Student Enrollment - Select the Student </h1>
            </header>
            <div>
                <h2>Select the student to enroll:</h2>
                <ul>
                    {students && students.length > 0 && students.map(student =>
                        <li key={student.username} style={{listStyleType:"none"}}>
                            <input onChange={() => setStudentInCourse({...studentInCourse, studentUsername: student.username})}
                                   type="radio"
                                   value={student.username} name={student.username}/>
                            <label> {student.name + student.surname} </label>
                        </li>)}
                </ul>
                <Button onClick={() => addStudentInCourse()}>Submit</Button>
                <Link to={"/students/add"}>Add Student</Link>
            </div>
        </div>
    )
}