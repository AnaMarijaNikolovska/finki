import React, {useEffect, useState} from "react";
import axios from "../components/AxiosConfig";
import {navigate} from "@reach/router";
import Button from "react-bootstrap/Button";

export default function TeacherDetails(props){
    const [teacherDetails, setTeacherDetails]= useState(null);

    useEffect(() => {
        axios.get(`/teachers/${props.teacherId}`)
            .then(r => {
                setTeacherDetails(r.data)
            })
    }, [])

    const handleDelete = () => {
        axios.delete(`/teachers/${props.teacherId}`)
            .then(() => {
                navigate("/teachers")
                    .then(() => window.location.reload())
            })
    }
    return(
        <div>
            <h1>Teacher</h1>

            {teacherDetails &&
            <p key={teacherDetails.teacherId}>
                {teacherDetails.name + " " + teacherDetails.surname}
            </p>}

            <Button onClick={handleDelete}>
                Delete
            </Button>
        </div>
    )
}