import React, {useEffect, useState} from "react";
import ListGroup from "react-bootstrap/ListGroup";
import {Link} from "@reach/router";
import axios from "../components/AxiosConfig";

export default function ListTeachers(){
    const [teachers, setTeachers] = useState(null);
    const [checkedTeacher, setCheckedTeacher] = useState(null);
    useEffect(() => {
        axios.get("/teachers")
            .then(res => {
                setTeachers(res.data)
            })
    }, []);
    const selectCourse = teacherId => {
        setCheckedTeacher(teacherId)
    }
    return(
        <div>
            <header>
                <h1>Teachers List</h1>
            </header>
            <main>
                <h2>Choose teacher:</h2>
                <ul>
                    {teachers && teachers.length > 0 && teachers.map(teacher =>
                        <li key={teacher.id} style={{listStyleType: "none"}}>
                            <input key={teacher.id} type="radio" value={teacher.id} name={teacher.id}
                                   onChange={() => selectCourse(teacher.id)}/>
                            <label> {teacher.name + " " + teacher.surname} </label>
                        </li>)}
                </ul>
                <br/>
                <Link to={"/courses"} state={{courseId:checkedTeacher}}>Submit</Link>
                <br/>
                <Link to={"/teachers/add"}>Add Course</Link>
            </main>
        </div>
    )
}