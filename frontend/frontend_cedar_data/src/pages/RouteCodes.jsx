import {useState} from "react";
import {useParams} from "react-router-dom";
import {useEffect} from "react";

export default function RouteCodes() {

    const [addresses, setAddresses] = useState([]);
    const {routeNumber} = useParams();

    function handleAddresses() {

        const getUrl = `http://localhost:8080/codes/${routeNumber}`;

        const addressObj = {
            method: "GET"
        }

        fetch(getUrl, addressObj)
            .then((response) => {
                if(!response.ok) {
                    throw new Error(`Network response error: ${response.status}`);
                }
                return response.json();
            })
            .then((data) => {
                setAddresses(data);
            })
            .catch((error) => {
               throw new Error(`There was a problem with the fetch request: ${error.status}`);
            });
    }

    function RenderAddress({addressObj}) {
        return (
            <li>
                <div className={"container"}>
                    <h2>{addressObj.streetNumber} {addressObj.streetName} {addressObj.cityName} {addressObj.zipCode}</h2>
                    <h3>Route: {addressObj.routeNumber}</h3>
                    <h3>Gate Code: {addressObj.gateCode}</h3>
                    <h3>Mailroom Code: {addressObj.mailRoomCode}</h3>
                    <h3>Amazon Locker Code: {addressObj.locker_code}</h3>
                </div>
            </li>
        )
    }


        useEffect(() => {
            handleAddresses()
        }, []);

    return (
        <main>
            <div>
                <h2 id={"mainTitle"}>Route {routeNumber} Codes</h2>
                <ul>
                    {addresses.map((address) => {
                        return <RenderAddress addressObj={address} key={address.address_id}/>
                    })}
                </ul>
            </div>
        </main>
    )
}