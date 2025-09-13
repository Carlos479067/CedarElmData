import './App.css'
import Header from "./components/Header.jsx";
import Navbar from "./components/Navbar.jsx";
import Footer from "./components/Footer.jsx";
import Home from "./pages/Home.jsx";
import RouteCodes from "./pages/RouteCodes.jsx";
import Forms from "./pages/Forms.jsx";
import RouteSplits from "./pages/RouteSplits.jsx";
import {useEffect, useState} from "react";
import {Navigate, Route, Routes} from "react-router-dom";
import Login from "./pages/Login.jsx";
import Signup from "./pages/Signup.jsx";

function App() {

    const [searchResults, setSearchResults] = useState("");
    // const [loggedInUser, setLoggedInUser] = useState("");

    // useEffect(() => {
    //     // Retrieve saved user object from localStorage
    //     const savedUser = localStorage.getItem("user");
    //
    //     if (savedUser) {
    //         // Parse JSON string back into an object and update state
    //         setLoggedInUser(JSON.parse(savedUser));
    //     }
    // }, []);


    function updateState(data) {
        setSearchResults(data);
    }

    function resetState() {
        setSearchResults([]);
    }

  return (
    <div className={"pageContainer"}>
      <Header searchResults={searchResults}/>
      <Navbar updateState={updateState} resetState={resetState}/>
        <main className={"appMain"}>
        <Routes>
            {/*<Route path={"/login"} element={<Login loggedInUser={loggedInUser} setLoggedInUser={setLoggedInUser}/>}/>*/}
            {/*<Route path={"/signup"} element={<Signup />}/>*/}
            <Route path={"/"} element={<Home searchResults={searchResults}/>}/>
            <Route path={"/forms"} element={<Forms />}/>
            <Route path={"/codes/:routeNumber"} element={<RouteCodes/>}/>
            <Route path={"/splits/:routeNumber"} element={<RouteSplits/>}/>
        </Routes>
            </main>
        <Footer/>
    </div>
  )
}

export default App
