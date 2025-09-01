import {useState} from "react";

export default function Navbar({searchResults}) {

    const [addressSearch, setAddressSearch] = useState("");

    function HandleQuery(event) {
        // Gets user input
        setAddressSearch(event.target.value);
    }

    function HandleSearchButton(event) {
        // Prevent reloading page when button clicked
        event.preventDefault();

        //Build full url
        const getUrl = "http://localhost:8080/";
        //Create object request
        //send request using fetch
        //check if response is ok
        //handle the data
        //handle errors
    }

    return (
        <nav className={"navbar"}>
            <ul>
                <li className={"dropdown"}>
                    <a><h3>Route Codes</h3></a>
                    <ul className={"dropdown-content"}>
                        <li><a>4925</a></li>
                        <li><a>4929</a></li>
                        <li><a>4930</a></li>
                        <li><a>4933</a></li>
                        <li><a>4934</a></li>
                        <li><a>4935</a></li>
                        <li><a>4937</a></li>
                        <li><a>4938</a></li>
                        <li><a>4942</a></li>
                        <li><a>4948</a></li>
                        <li><a>4952</a></li>
                        <li><a>4954</a></li>
                    </ul>
                </li>
                <li className={"dropdown"}>
                    <a><h3>Route Splits</h3></a>
                    <ul className={"dropdown-content"}>
                        <li><a>4925</a></li>
                        <li><a>4929</a></li>
                        <li><a>4930</a></li>
                        <li><a>4933</a></li>
                        <li><a>4934</a></li>
                        <li><a>4935</a></li>
                        <li><a>4937</a></li>
                        <li><a>4938</a></li>
                        <li><a>4942</a></li>
                        <li><a>4948</a></li>
                        <li><a>4952</a></li>
                        <li><a>4954</a></li>
                    </ul>
                </li>
            </ul>
            <div>
                <form className={"search-bar"} onSubmit={HandleSearchButton}>
                    <input className={"search"} type={"text"} placeholder={"Search Address..."} onChange={HandleQuery}></input>
                    <button className={"btn-search"} type={"submit"}>Go</button>
                </form>
            </div>
        </nav>
    )
}