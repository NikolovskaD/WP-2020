import React, {Component} from "react";
import {Button, Card, Col, Form} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faEdit, faList, faPlusSquare, faSave, faUndo} from '@fortawesome/free-solid-svg-icons'
import axios from 'axios';
import MyToast from "./MyToast";

export default class NewManufacturer extends Component{

    constructor(props){
        super(props);
        this.state = this.initialState;
        this.manufacturerChange = this.manufacturerChange.bind(this);
        this.submitManufacturer = this.manufacturerChange.bind(this);
    }

    initialState = {
        id:'', name:'', address:''
    };

    componentDidMount() {
        const manufacturerId = +this.props.match.params.id;
        if (manufacturerId){
            this.findManufacturerById(manufacturerId);
        }
    };

    findManufacturerById = (manufacturerId) => {
        axios.get("http://localhost:8080/api/manufacturers/" + manufacturerId)
            .then(resp => {
                if (resp.data != null){
                    this.setState({
                        id: resp.data.id,
                        name: resp.data.name,
                        address: resp.data.address
                    })
                }
            }).catch((error) => {
            console.error("Error - " + error);
        });
    };

    submitManufacturer = event => {
        event.preventDefault();

        const man = {
            name: this.state.name,
            address: this.state.address
        };

        /*var params = new URLSearchParams();
        params.append('name', this.state.name);
        params.append('address', this.state.address);*/

        /*axios({
            method: 'post',
            url: "http://localhost:8080/api/manufacturers",
            headers: {},
            data: {
                name: this.state.name,
                address: this.state.address
            }
        })
            .then(response => {
                if (response.data != null){
                    this.setState(this.initialState);
                    alert("Manufacturer saved successfully!");
                }
            });*/

        /*axios.post("http://localhost:8080/api/manufacturers", man, {
            headers: {
                'Content-Type': 'application/json'
            }
        })*/
        axios.post("http://localhost:8080/api/manufacturers", man)
            .then(response => {
                if (response.data != null){
                    this.setState({"show":true, "method":"post"});
                    setTimeout(() => this.setState({"show":false}), 3000);
                } else {
                    this.setState({"show":false});
                }
            });

        this.setState(this.initialState);

    };

    resetManufacturer = () => {
        this.setState(() => this.initialState);
    };

    manufacturerChange = event => {
        this.setState({
            [event.target.name]:event.target.value
        });
    };

    updateManufacturer = event => {
        event.preventDefault();

        const man = {
            id: this.state.id,
            name: this.state.name,
            address: this.state.address
        };

        axios.put("http://localhost:8080/api/manufacturers", man)
            .then(response => {
                if (response.data != null){
                    this.setState({"show":true, "method":"put"});
                    setTimeout(() => this.setState({"show":false}), 3000);
                    setTimeout(() => this.manufacturerList(), 3000);
                } else {
                    this.setState({"show":false});
                }
            });

        this.setState(this.initialState);
    };

    manufacturerList = () => {
        return this.props.history.push("/manufacturers");
    };

    render() {
        const {name, address} = this.state;

        return (
            <div>
                <div style={{"display":this.state.show ? "block" : "none"}}>
                    <MyToast show = {this.state.show} message={this.state.method === "put" ? "Manufacturer Updated Successfully." : "Manufacturer Saved Successfully."} type={"success"}/>
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header><FontAwesomeIcon icon={this.state.id ? faEdit : faPlusSquare}/> {this.state.id ? "Update Manufacturer" : "Add New Manufacturer"} </Card.Header>
                    <Form onReset={this.resetManufacturer} onSubmit={this.state.id ? this.updateManufacturer : this.submitManufacturer}  id="manufacturersFormId">
                        <Card.Body>
                            <Form.Row>
                                <Form.Group as={Col} controlId="formGridName">
                                    <Form.Label>Name</Form.Label>
                                    <Form.Control type="text" name="name" autoComplete="off"
                                                  value={name} onChange={this.manufacturerChange} required
                                                  className={"bg-dark text-white"} placeholder="Enter Manufacturer's Name" />
                                </Form.Group>
                                <Form.Group as={Col} controlId="formGridAddress">
                                    <Form.Label>Address</Form.Label>
                                    <Form.Control type="text" name="address" required autoComplete="off"
                                                  value={address} onChange={this.manufacturerChange}
                                                  className={"bg-dark text-white"} placeholder="Enter Manufacturer's Address" />
                                </Form.Group>
                            </Form.Row>
                        </Card.Body>
                        <Card.Footer style={{"textAlign":"right"}}>
                            <Button variant="info" size={"sm"} type="button" onClick={this.manufacturerList.bind()}>
                                <FontAwesomeIcon icon={faList} /> Manufacturers List
                            </Button> {' '}
                            <Button variant="info" size={"sm"} type="reset">
                                <FontAwesomeIcon icon={faUndo} /> Reset
                            </Button>  {' '}
                            <Button variant="success" size={"sm"} type="submit">
                                <FontAwesomeIcon icon={faSave} /> {this.state.id ? "Update" : "Save"}
                            </Button>
                        </Card.Footer>
                    </Form>
                </Card>
            </div>


        );
    }
}