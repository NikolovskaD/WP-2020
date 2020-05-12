import React, {Component} from "react";
import {Button, ButtonGroup, Card, FormControl, Image, InputGroup, Table} from "react-bootstrap";
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
import MyToast from "../MyToast";
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
        const {products, currentPage, productsPerPage} = this.state;
        const lastIndex = currentPage * productsPerPage;
        const firstIndex = lastIndex - productsPerPage;
        const currentProducts = products.slice(firstIndex,lastIndex);
        const totalPages = parseInt(products.length / productsPerPage + 1);

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
                    <MyToast children = {{show:this.state.show, message:"Product Deleted Successfully.", type:"danger"}}/>
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header><FontAwesomeIcon icon={faList} /> Products List
                        <div align="right">
                            <Link to={"add-product"} className="btn btn-sm btn-outline-light" >Add New Product <FontAwesomeIcon icon={faPlusCircle}/></Link>
                        </div>
                    </Card.Header>
                    <Card.Body>
                        <Table bordered hover striped variant="dark">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                {/*<th>Manufacturer</th>*/}
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                products.length === 0 ?
                                    <tr align="center">
                                        <td colSpan="6">No Products Available</td>
                                    </tr> :
                                    currentProducts.map((product) => (
                                        <tr key={product.id}>
                                            <td>
                                                {/*<Image src={product.img} roundedCircle width="25" height="25"/>*/}
                                                {" " + product.name}
                                            </td>
                                            <td> {product.price}  </td>
                                            <td> {product.quantity}  </td>
                                            {/*<td> {product.manufacturer}  </td>*/}
                                            <td>
                                                <ButtonGroup>
                                                    <Button variant="outline-primary"><FontAwesomeIcon icon={faEdit} /> </Button> {" "}
                                                    <Button variant="outline-danger" onClick={this.deleteProduct.bind(this,product.id)}><FontAwesomeIcon icon={faTrash} /></Button>
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
