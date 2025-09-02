export default function Home ({searchResults}) {

    let contentToRender = <></>;

    if(searchResults.length === 0) {
        contentToRender =
            <>
                <div>
                    <h2>Route Codes</h2>
                    <ul>
                        <li><a>Route 4934</a></li>
                    </ul>
                </div>
                <div>
                    <h2>Route Splits</h2>
                    <ul>
                        <li><a>Route 4934</a></li>
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

    return (
        <main id={"main"}>
            {contentToRender}
        </main>
    )
}