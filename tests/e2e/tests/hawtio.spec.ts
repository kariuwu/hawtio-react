import { expect, test } from '@playwright/test'

test('hawtio page loads', async ({ page }) => {
  await page.goto('/')
  await expect(page).toHaveTitle(/Hawtio/)
})
