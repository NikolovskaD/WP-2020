import React, {Component} from "react";
import {Jumbotron} from "react-bootstrap";


export default class Play extends Component{
    render() {
        return (
            <div>
                <div>
                    <Jumbotron className="bg-dark text-white text-center">
                        <h1>Follow the latest tournaments!</h1>
                        <blockquote className="blockquote mb-0">
                            <p> Checkout some of the most recent games, analysed by GMs from ChessBase </p>
                        </blockquote>
                        <iframe src='http://live.chessbase.com/watch/FIDE-Chesscom-Online-Nations-Cup' width="900" height="600"/><br/><br/><br/>
                        <h2>Tired of shopping? Can't wait to play? </h2>
                        <blockquote className="blockquote mb-0">
                            <p> Join the Online ChessBase Community </p>
                        </blockquote>
                        <div className="bg-dark">
                            <iframe src="https://play.chessbase.com" width="400" height="440" />
                            <iframe src="https://liveblitz.chessbase.com" width="400" height="440" />
                        </div>
                    </Jumbotron>
                </div>
            </div>
        );
    }
}


/*“Chess is beautiful enough to waste your life for.” – Hans Ree*/
