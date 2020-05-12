import React, {Component} from "react";
import {Button, ButtonGroup, Card, CardColumns, CardDeck, FormControl, Image, InputGroup, Table} from "react-bootstrap";

import axios from 'axios';


export default class Products extends Component{

    constructor(props) {
        super(props);
        this.state = {
            products : [],
            currentPage : 1,
            productsPerPage: 10
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/products")
            .then(response => response.data)
            .then((data) => {
                this.setState({products: data});
            });
    }


    render() {
        const {products} = this.state;

        return (
            <div>
                <CardColumns>
                    {
                        products.length === 0 ?
                            <div align="center" className={"border border-dark bg-dark text-white"}>
                                <p>No Products Available</p>
                            </div>
                             :
                            products.map((product) => (
                            <Card key={product.id} className={"border border-dark bg-dark text-white"} >
                                <Card.Img variant="top" src={product.imgUrl} />
                                <Card.Body key={product.id}>
                                    <Card.Title>
                                        <blockquote className="blockquote mb-0">
                                        <p> {product.name} </p>
                                        <footer className="blockquote-footer">
                                            {product.manufacturer.name}
                                        </footer>
                                    </blockquote>
                                    </Card.Title>
                                    <Card.Text>{' '}{product.description}
                                    </Card.Text>
                                </Card.Body>
                                <Card.Footer >
                                    <div>
                                        <p align="left">{product.price}$</p>
                                        <Button size="sm" variant="outline-success" placement="right"/*{style={{float:'right'}}}*/>Buy</Button>
                                    </div>
                                </Card.Footer>
                            </Card>
                            ))
                    }
                </CardColumns>
            </div>
        );
    }
}
