import React, {Component} from "react";
import {Button, Card, Col, Form} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPlusSquare, faSave, faUndo} from '@fortawesome/free-solid-svg-icons'
import axios from 'axios';

export default class NewProduct extends Component{

    constructor(props){
        super(props);
        this.state = this.initialState;
        this.productChange = this.productChange.bind(this);
        this.submitProduct = this.submitProduct.bind(this);
    }

    initialState = {
        name:'', price:'', quantity:'', img:'', manufacturer:''
    }

    submitProduct = event =>{
        event.preventDefault();

        const product = {
            name: this.state.name,
            price: this.state.price,
            quantity: this.state.quantity,
            photo: this.state.img,
            manufacturer: this.state.manufacturer
        };
    }

    resetProduct = () => {
        this.setState(() => this.initialState);
    }

    productChange = event =>{
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    render() {
        const {name, price, quantity, img, manufacturer} = this.state;

        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header><FontAwesomeIcon icon={faPlusSquare}/> Add New Product  </Card.Header>
                <Form onReset={this.resetProduct} onSubmit={this.submitProduct}  id="productsFormId">
                    <Card.Body>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formGridName">
                                <Form.Label>Name</Form.Label>
                                <Form.Control type="text" name="name" autoComplete="off"
                                              value={name} onChange={this.productChange} required
                                              className={"bg-dark text-white"} placeholder="Enter the name of the product" />
                            </Form.Group>
                            <Form.Group as={Col} controlId="formGridPrice">
                                <Form.Label>Price</Form.Label>
                                <Form.Control type="text" name="price" required autoComplete="off"
                                              value={price} onChange={this.productChange}
                                              className={"bg-dark text-white"} placeholder="Enter the price of the product" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formGridQuantity">
                                <Form.Label>Quantity</Form.Label>
                                <Form.Control type="text" name="quantity" required autoComplete="off"
                                              value={quantity} onChange={this.productChange}
                                              className={"bg-dark text-white"} placeholder="Quantity" />
                            </Form.Group>
                            <Form.Group as={Col} controlId="formGridPhoto">
                                <Form.Label>Photo</Form.Label>
                                <Form.Control type="text" name="img" className={"bg-dark text-white"}
                                              value={img} onChange={this.productChange} autoComplete="off"
                                              placeholder="Enter the photo of the product" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formGridManufacturer">
                                <Form.Label>Manufacturer</Form.Label>
                                <Form.Control type="text" name="manufacturer" className={"bg-dark text-white"}
                                              value={manufacturer} onChange={this.productChange} autoComplete="off"
                                              placeholder="Manufacturer" />
                            </Form.Group>
                        </Form.Row>
                    </Card.Body>
                <Card.Footer style={{"textAlign":"right"}}>
                    <Button variant="info" size={"sm"} type="reset">
                        <FontAwesomeIcon icon={faUndo} /> Reset
                    </Button> {' '}
                    <Button variant="success" size={"sm"} type="submit">
                        <FontAwesomeIcon icon={faSave} /> Submit
                    </Button>
                </Card.Footer>
            </Form>
            </Card>
        );
    }
}