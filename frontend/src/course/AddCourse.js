import React, {useState} from 'react'
import axios from '../components/AxiosConfig';
import Button from "react-bootstrap/Button";
import Form from 'react-bootstrap/Form'
import {navigate} from "@reach/router";

export function AddCourse() {

    const [course, setCourse] = useState({
        name: '',
        description: '',
        teacherId: 0,
        type: '',
        studentUsernames:[],
    });

    const types = ["WINTER", "SUMMER", "MANDATORY", "ELECTIVE"]

    const handleChange = name => event => {
        setCourse({...course, [name]: event.target.value});
    };

    const handleSubmit = event => {
        event.preventDefault();

        axios.post("/courses", course)
            .then(res => {
                navigate("/courses")
            })
    }

    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <Form.Group>
                    <Form.Label>Name</Form.Label>
                    <Form.Control placeholder="Enter name"
                                  onChange={handleChange("name")}/>
                </Form.Group>


                <Form.Group>
                    <Form.Label>Description</Form.Label>
                    <Form.Control placeholder="Enter description"
                                  onChange={handleChange("description")}/>
                </Form.Group>

                <Form.Group>
                    <select onChange={handleChange("type")}>
                        <option>---</option>
                        {types.map((type, key) => <option key={key} value={type}>
                            {type}
                        </option> )}
                    </select>
                </Form.Group>

                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </div>
    )
}