from bs4 import BeautifulSoup
import urllib2

webpage = urllib2.urlopen('http://www.xfront.com/us_states/')
# soup = BeautifulSoup(webpage,'html.parser')
# print(soup.get_text())

soup = BeautifulSoup(webpage)
inner_items = [li.text.strip() for li in soup.find_all('li')]
print(inner_items)
