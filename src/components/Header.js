import styles from '../css/Header.module.css'
import cadastro from '../assets/icons/cadastro.png'
import login from '../assets/icons/login.png'
import home from '../assets/icons/home.png'
import { useState } from 'react'

export default function Header() {
    let [isMenu, setMenu] = useState(false)

    function ativarMenu() {
        setMenu(!isMenu)
    }

    return (
        <header className={`${styles.header} ${isMenu ? styles.ativo : ''}`} onClick={ativarMenu}>
            <div className={`${styles.burguer} ${isMenu ? styles.ativo : ''}`} onClick={ativarMenu}>
                <div></div>
                <div></div>
                <div></div>
            </div>
            <ul className={`${styles.menu} ${isMenu ? styles.ativo : ''}`}>
                <li><img src={home} alt="" /><p>Inicio</p></li>
                <li><img src={cadastro} alt="" /><p>Cadastrar</p></li>
                <li><img src={login} alt="" /><p>Logar</p></li>
            </ul>
        </header>
    )
}