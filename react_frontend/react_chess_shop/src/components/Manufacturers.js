import React, {Component} from "react";
import {Button, ButtonGroup, Card, FormControl, InputGroup, Table} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {
    faEdit,
    faFastBackward,
    faFastForward,
    faList,
    faStepBackward,
    faStepForward,
    faTrash, faUserPlus
} from '@fortawesome/free-solid-svg-icons'
import axios from 'axios';
import MyToast from "./MyToast";
import {Link} from "react-router-dom";

export default class Manufacturers extends Component{

    constructor(props) {
        super(props);
        this.state = {
            manufacturers : [],
            currentPage : 1,
            manufacturersPerPage: 5
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/manufacturers")
            .then(response => response.data)
            .then((data) => {
                this.setState({manufacturers: data});
            });
    }

    deleteManufacturer = (manufacturerId) => {
        axios.delete("http://localhost:8080/api/manufacturers/" + manufacturerId)
            .then(resp => {
                if (resp.data != null){
                    this.setState({"show":true});
                    setTimeout(() => this.setState({"show":false}), 3000);

                    this.setState({
                       manufacturers: this.state.manufacturers.filter(manufacturer => manufacturer.id !== manufacturerId)
                    });
                } else {
                    this.setState({"show":false});
                }
            });
    };

    changePage = event => {
        this.setState({
            [event.target.name]: parseInt(event.target.value)
        });
    };

    firstPage = () => {
        if(this.state.currentPage > 1) {
            this.setState({
                currentPage: 1
            });
        }
    };

    prevPage = () => {
        if(this.state.currentPage > 1) {
            this.setState({
                currentPage: this.state.currentPage - 1
            });
        }
    };

    lastPage = () => {
        if(this.state.currentPage < Math.ceil(this.state.manufacturers.length / this.state.manufacturersPerPage)) {
            this.setState({
                currentPage: Math.ceil(this.state.manufacturers.length / this.state.manufacturersPerPage)
            });
        }
    };

    nextPage = () => {
        if(this.state.currentPage < Math.ceil(this.state.manufacturers.length / this.state.manufacturersPerPage)) {
            this.setState({
                currentPage: this.state.currentPage + 1
            });
        }
    };

    render() {
        const {manufacturers, currentPage, manufacturersPerPage} = this.state;
        const lastIndex = currentPage * manufacturersPerPage;
        const firstIndex = lastIndex - manufacturersPerPage;
        const currentManufacturers = manufacturers.slice(firstIndex,lastIndex);
        const totalPages = parseInt(manufacturers.length / manufacturersPerPage + 1);

        const pageNumCss = {
            width: "45px",
            border: "1px solid #17A2B8",
            color: "#17A2B8",
            textAlign: "center",
            fontWeight: "bold"
        };
        
        return (
            <div>
                <div style={{"display":this.state.show ? "block" : "none"}}>
                    <MyToast show={this.state.show} message={"Manufacturer Deleted Successfully."} type={"danger"}/>
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header><FontAwesomeIcon icon={faList} /> Manufacturers List
                        <div align="right">
                            <Link to={"add-manufacturer"} className="btn btn-sm btn-outline-light" >Add New Manufacturer <FontAwesomeIcon icon={faUserPlus}/></Link>
                        </div>
                    </Card.Header>
                    <Card.Body>
                        <Table bordered hover striped variant="dark">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                manufacturers.length === 0 ?
                                    <tr align="center">
                                        <td colSpan="6">No Manufacturers Available</td>
                                    </tr> :
                                    currentManufacturers.map((manufacturer) => (
                                        <tr key={manufacturer.id}>
                                            <td> {" " + manufacturer.name} </td>
                                            <td> {manufacturer.address}  </td>
                                            <td>
                                                <ButtonGroup>
                                                    <Link to={"edit/"+manufacturer.id} className="btn btn-sm btn-outline-primary"><FontAwesomeIcon icon={faEdit}/></Link>{" "}
                                                    <Button variant="outline-danger" onClick={this.deleteManufacturer.bind(this,manufacturer.id)}><FontAwesomeIcon icon={faTrash} /></Button>
                                                </ButtonGroup>
                                            </td>
                                        </tr>
                                    ))
                            }
                            </tbody>
                        </Table>
                    </Card.Body>
                    <Card.Footer>
                        <div style={{"float":"left"}}>
                            Showing Page {currentPage} out of {totalPages}
                        </div>
                        <div style={{"float":"right"}}>
                            <InputGroup size="sm">
                                <InputGroup.Prepend>
                                    <Button type="button" variant="outline-info" disabled={currentPage === 1 ? true : false}
                                            onClick={this.firstPage}>
                                        <FontAwesomeIcon icon={faFastBackward} /> First
                                    </Button>
                                    <Button type="button" variant="outline-info" disabled={currentPage === 1 ? true : false}
                                            onClick={this.prevPage}>
                                        <FontAwesomeIcon icon={faStepBackward} /> Prev
                                    </Button>
                                </InputGroup.Prepend>
                                <FormControl style={pageNumCss} className={"bg-dark"} name="currentPage" value={currentPage}
                                             onChange={this.changePage}/>
                                <InputGroup.Append>
                                    <Button type="button" variant="outline-info" disabled={currentPage === totalPages ? true : false}
                                            onClick={this.nextPage}>
                                        <FontAwesomeIcon icon={faStepForward} /> Next
                                    </Button>
                                    <Button type="button" variant="outline-info" disabled={currentPage === totalPages ? true : false}
                                            onClick={this.lastPage}>
                                        <FontAwesomeIcon icon={faFastForward} /> Last
                                    </Button>
                                </InputGroup.Append>
                            </InputGroup>
                        </div>
                    </Card.Footer>
                </Card>
            </div>

        );
    }
}
