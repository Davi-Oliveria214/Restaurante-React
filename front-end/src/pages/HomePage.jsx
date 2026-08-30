import styles from '../css/HomePage.module.css'
import Carrossel from '../components/Carrossel.jsx'
import Banner from '../components/Banner.jsx'

export function HomePage() {
    return (
        <main className={styles.main}>
            <Banner />
            <Carrossel />
        </main>
    )
}