import Carrossel from '../components/Carrossel.jsx'
import Banner from '../components/Banner.jsx'

export function HomePage() {
    return (
        <main className='flex flex-1 flex-col overflow-y-scroll scrollbar-none'>
            <Banner />
            <Carrossel />
        </main>
    )
}