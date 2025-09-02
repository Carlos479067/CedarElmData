import './App.css'
import Header from "./components/Header.jsx";
import Navbar from "./components/Navbar.jsx";
import Footer from "./components/Footer.jsx";
import Home from "./pages/Home.jsx";
import {useState} from "react";
import {Route, Routes} from "react-router-dom";

function App() {

    const [searchResults, setSearchResults] = useState("");

    function updateState(data) {
        setSearchResults(data);
    }

    function resetState() {
        setSearchResults([]);
    }

  return (
    <>
      <Header searchResults={searchResults}/>
      <Navbar updateState={updateState} resetState={resetState}/>
        <Routes>
            <Route path={"/"} element={<Home searchResults={searchResults}/>}/>
        </Routes>
        <Footer/>
    </>
  )
}


export default App
