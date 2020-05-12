import React, {Component} from "react";
import {Button, ButtonGroup, Card, CardColumns, CardDeck, FormControl, Image, InputGroup, Table} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {
    faEdit,
    faFastBackward,
    faFastForward,
    faList, faPlusCircle,
    faStepBackward,
    faStepForward,
    faTrash, faUserPlus
} from '@fortawesome/free-solid-svg-icons'
import axios from 'axios';
import MyToast from "./MyToast";
import {Link} from "react-router-dom";

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

    deleteProduct = (productId) => {
        axios.delete("http://localhost:8080/api/products/" + productId)
            .then(resp => {
                if (resp.data != null){
                    this.setState({"show":true});
                    setTimeout(() => this.setState({"show":false}), 3000);
                    this.setState({
                        products: this.state.products.filter(product => product.id !== productId)
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
        if(this.state.currentPage < Math.ceil(this.state.products.length / this.state.productsPerPage)) {
            this.setState({
                currentPage: Math.ceil(this.state.products.length / this.state.productsPerPage)
            });
        }
    };

    nextPage = () => {
        if(this.state.currentPage < Math.ceil(this.state.products.length / this.state.productsPerPage)) {
            this.setState({
                currentPage: this.state.currentPage + 1
            });
        }
    };

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
                            <Card key={product.id} className={"border border-dark bg-dark text-white"}>
                                <Card.Img variant="top" src={product.imgUrl} />
                                <Card.Body key={product.id}>
                                    <Card.Title>{product.name}</Card.Title>
                                    <Card.Text>{product.manufacturer.name}{' '}{product.description}  </Card.Text>
                                </Card.Body>
                                <Card.Footer >
                                    <div>
                                        <p >{product.price}$</p>
                                        <Button size="sm" variant="outline-success" align="right">Buy</Button>
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
