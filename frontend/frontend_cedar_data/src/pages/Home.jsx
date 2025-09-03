import {NavLink} from "react-router-dom";

export default function Home ({searchResults}) {

    let contentToRender = <></>;

    if(searchResults.length === 0) {
        contentToRender =
            <>
                <div>
                    <h2>Route Codes</h2>
                    <ul>
                        <li><NavLink to={"/codes/4925"}>Route 4925</NavLink></li>
                        <li><NavLink to={"/codes/4929"}>Route 4929</NavLink></li>
                        <li><NavLink to={"/codes/4930"}>Route 4930</NavLink></li>
                        <li><NavLink to={"/codes/4933"}>Route 4933</NavLink></li>
                        <li><NavLink to={"/codes/4934"}>Route 4934</NavLink></li>
                        <li><NavLink to={"/codes/4935"}>Route 4935</NavLink></li>
                        <li><NavLink to={"/codes/4937"}>Route 4937</NavLink></li>
                        <li><NavLink to={"/codes/4938"}>Route 4938</NavLink></li>
                        <li><NavLink to={"/codes/4942"}>Route 4942</NavLink></li>
                        <li><NavLink to={"/codes/4943"}>Route 4943</NavLink></li>
                        <li><NavLink to={"/codes/4948"}>Route 4948</NavLink></li>
                        <li><NavLink to={"/codes/4952"}>Route 4952</NavLink></li>
                        <li><NavLink to={"/codes/4954"}>Route 4954</NavLink></li>

                    </ul>
                </div>
                <div>
                <h2>Route Splits</h2>
                    <ul>
                        <li><NavLink to={"/codes/4925"}>Route 4925</NavLink></li>
                        <li><NavLink to={"/codes/4929"}>Route 4929</NavLink></li>
                        <li><NavLink to={"/codes/4930"}>Route 4930</NavLink></li>
                        <li><NavLink to={"/codes/4933"}>Route 4933</NavLink></li>
                        <li><NavLink to={"/codes/4934"}>Route 4934</NavLink></li>
                        <li><NavLink to={"/codes/4935"}>Route 4935</NavLink></li>
                        <li><NavLink to={"/codes/4937"}>Route 4937</NavLink></li>
                        <li><NavLink to={"/codes/4938"}>Route 4938</NavLink></li>
                        <li><NavLink to={"/codes/4942"}>Route 4942</NavLink></li>
                        <li><NavLink to={"/codes/4943"}>Route 4943</NavLink></li>
                        <li><NavLink to={"/codes/4948"}>Route 4948</NavLink></li>
                        <li><NavLink to={"/codes/4952"}>Route 4952</NavLink></li>
                        <li><NavLink to={"/codes/4954"}>Route 4954</NavLink></li>
                    </ul>
                </div>
            </>
    } else {
        contentToRender =
            <>
                <MapAddress address={searchResults}/>
            </>
    }

    function MapAddress({address}) {

        return (
            <>
                {address.length > 0 ? (
                    <div>
                        <ul>
                            {address.map((addresses) => (
                                <RenderAddress addressObj={addresses} key={addresses.address_id}/>
                            ))}
                        </ul>
                    </div>

                ) : (<p>No address found</p>)
                }
            </>

        )
    }

    function RenderAddress({addressObj}) {
        return (
            <li>
                <div className={"searchContainer"}>
                    <h2>{addressObj.streetNumber} {addressObj.streetName} {addressObj.cityName} {addressObj.zipCode}</h2>
                    <h3>Route: {addressObj.routeNumber}</h3>
                    <h3>Gate Code: {addressObj.gateCode}</h3>
                    <h3>Mailroom Code: {addressObj.mailRoomCode}</h3>
                    <h3>Amazon Locker Code: {addressObj.locker_code}</h3>
                </div>
            </li>
        )
    }

    return (
        <main id={"main"}>
            {contentToRender}
        </main>
    )
}