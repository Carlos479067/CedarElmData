import './App.css'
import Header from "./components/Header.jsx";
import Navbar from "./components/Navbar.jsx";
import Footer from "./components/Footer.jsx";
import Home from "./pages/Home.jsx";
import RouteCodes from "./pages/RouteCodes.jsx";
import {useState} from "react";
import {Route, Routes} from "react-router-dom";
import Login from "./pages/Login.jsx";

function App() {

    const [searchResults, setSearchResults] = useState("");

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
        <main style={{flex: "1"}}>
        <Routes>
            <Route path={"/login"} element={<Login />}/>
            <Route path={"/"} element={<Home searchResults={searchResults}/>}/>
            <Route path={"/codes/:routeNumber"} element={<RouteCodes/>}/>
        </Routes>
            </main>
        <Footer/>
    </div>
  )
}


export default App
